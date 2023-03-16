package users

import (
	"BankingApp/database/config"
	"BankingApp/helpers/hash"
	"BankingApp/helpers/interfaces"
	"BankingApp/helpers/validation"
	"BankingApp/jasonWebToken"
	"BankingApp/models/entities"
	"BankingApp/models/response"
	"golang.org/x/crypto/bcrypt"
)

func Login(username string, pass string) map[string]interface{} {
	valid := validation.Validation([]interfaces.Validation{{Value: username, Valid: "username"}, {Value: pass, Valid: "password"}})
	if valid {
		//Connect db
		user := &entities.User{}
		if config.DB.Where("username= ?", username).First(&user).RecordNotFound() {
			return map[string]interface{}{"message": "User not found"}
		}

		//Verify Password
		passErr := bcrypt.CompareHashAndPassword([]byte(user.Password), []byte(pass))

		if passErr == bcrypt.ErrMismatchedHashAndPassword && passErr != nil {
			return map[string]interface{}{"message": "wrong password"}
		}

		//Find Account for User
		var accounts []response.ResponseAccount
		config.DB.Table("accounts").Select("id, name, balance").Where("user_id = ?", user.ID).Scan(&accounts)

		var response = jasonWebToken.PrepareResponse(user, accounts, true)
		return response
	} else {
		return map[string]interface{}{"message": "not valid values"}
	}
}

func Register(username string, email string, pass string) map[string]interface{} {
	valid := validation.Validation([]interfaces.Validation{{Value: username, Valid: "username"}, {Value: email, Valid: "email"}, {Value: pass, Valid: "password"}})
	if valid {
		generatedPassword := hash.HashAndSalt([]byte(pass))
		user := &entities.User{Username: username, Email: email, Password: generatedPassword}
		config.DB.Create(&user)

		account := &entities.Account{Type: "Daily Account", Name: string(username + "`s" + " account"), Balance: 0, UserID: user.ID}
		config.DB.Create(&account)

		accounts := []response.ResponseAccount{}
		resAccount := response.ResponseAccount{ID: account.ID, Name: account.Name, Balance: int(account.Balance)}
		accounts = append(accounts, resAccount)

		var response = jasonWebToken.PrepareResponse(user, accounts, true)
		return response
	} else {
		return map[string]interface{}{"message": "not valid values"}
	}

}
func GetUser(id string, jwt string) map[string]interface{} {
	isValid := validation.ValidateToken(id, jwt)
	if isValid {
		user := &entities.User{}
		if config.DB.Where("id= ?", id).First(&user).RecordNotFound() {
			return map[string]interface{}{"message": "User not found"}
		}
		//Find Account for User
		var accounts []response.ResponseAccount
		config.DB.Table("accounts").Select("id, name, balance").Where("user_id = ?", user.ID).Scan(&accounts)
		var response = jasonWebToken.PrepareResponse(user, accounts, false)
		return response
	} else {
		return map[string]interface{}{"message": "not valid values"}
	}
}

package jasonWebToken

import (
	"BankingApp/helpers/handler"
	"BankingApp/models/entities"
	"BankingApp/models/response"
	"github.com/dgrijalva/jwt-go"
	"time"
)

func prepareToken(user *entities.User) string {
	//Sign Token
	tokenContent := jwt.MapClaims{
		"user_id": user.ID,
		"expiry":  time.Now().Add(time.Minute * 60).Unix(),
	}

	jwtToken := jwt.NewWithClaims(jwt.GetSigningMethod("HS256"), tokenContent)
	token, err := jwtToken.SignedString([]byte("TokenPassword"))
	handler.HandleErr(err)

	return token
}

func PrepareResponse(user *entities.User, accounts []response.ResponseAccount, withToken bool) map[string]interface{} {
	responseUser := &response.ResponseUser{
		ID:       user.ID,
		Username: user.Username,
		Email:    user.Email,
		Accounts: accounts,
	}

	var response = map[string]interface{}{"message": "all is fine"}
	if withToken {
		var token = prepareToken(user)
		response["jasonWebToken"] = token
	}

	response["data"] = responseUser

	return response

}

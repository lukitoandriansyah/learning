package userAccounts

import (
	"BankingApp/controller/transactions"
	"BankingApp/database/config"
	"BankingApp/helpers/validation"
	"BankingApp/models/entities"
	"BankingApp/models/response"
	"fmt"
)

func updateAccount(id uint, amount int) response.ResponseAccount {
	account := entities.Account{}
	responseAcc := response.ResponseAccount{}
	config.DB.Where("id=?", id).First(&account)
	account.Balance = uint(amount)
	config.DB.Save(&account)

	responseAcc.ID = account.ID
	responseAcc.Name = account.Name
	responseAcc.Balance = int(account.Balance)
	return responseAcc
}

func getAccount(id uint) *entities.Account {

	account := &entities.Account{}
	if config.DB.Where("id = ?", id).First(&account).RecordNotFound() {
		return nil
	}
	return account
}

func Transaction(userId uint, from uint, to uint, amount int, jwt string) map[string]interface{} {
	userIdString := fmt.Sprint(userId)
	isValid := validation.ValidateToken(userIdString, jwt)

	if isValid {
		fromAccount := getAccount(from)
		toAccount := getAccount(to)
		if fromAccount == nil || toAccount == nil {
			return map[string]interface{}{"Message": "Account not found"}
		} else if fromAccount.UserID != userId {
			return map[string]interface{}{"Message": "You are not owner"}
		} else if int(fromAccount.Balance) <= amount {
			return map[string]interface{}{"Message": "Account balance is too small"}
		}

		updatedAccount := updateAccount(from, int(fromAccount.Balance)-amount)
		updateAccount(to, int(fromAccount.Balance)+amount)

		transactions.CreateTransaction(from, to, amount)
		var response = map[string]interface{}{"Message": "All is fine"}
		response["data"] = updatedAccount
		return response

	} else {
		return map[string]interface{}{"message": "not valid values"}
	}
}

package transactions

import (
	"BankingApp/database/config"
	"BankingApp/helpers/validation"
	"BankingApp/models/entities"
	"BankingApp/models/response"
)

func CreateTransaction(from uint, to uint, amount int) {
	transaction := &entities.Transaction{From: from, To: to, Amount: amount}
	config.DB.Create(&transaction)
}

func GetTransactionByAccount(id uint) []response.ResponseTransaction {
	transaction := []response.ResponseTransaction{}

	config.DB.Table("transactions").Select("id, transactions.from, transactions.to, amount").Where(entities.Transaction{From: id}).Or(entities.Transaction{To: id}).Scan(&transaction)
	return transaction
}

func GetMyTransaction(id string, jwt string) map[string]interface{} {
	isValid := validation.ValidateToken(id, jwt)
	if isValid {
		accounts := []response.ResponseAccount{}
		config.DB.Table("accounts").Select("id, name, balance").Where("user_id=?", id).Scan(&accounts)
		transactions := []response.ResponseTransaction{}
		for i := 0; i < len(accounts); i++ {
			accTransaction := GetTransactionByAccount(accounts[i].ID)
			transactions = append(transactions, accTransaction...)
		}
		var response = map[string]interface{}{"Message": "All is fine"}
		response["data"] = transactions
		return response
	} else {
		return map[string]interface{}{"Message": "Not Valid Value"}
	}
}

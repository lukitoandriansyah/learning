package migrations

import (
	"BankingApp/database/config"
	"BankingApp/models/entities"
)

func Migrate() {
	User := &entities.User{}
	Account := &entities.Account{}
	Transaction := &entities.Transaction{}
	config.DB.AutoMigrate(&User, &Account, &Transaction)
	/*createdAccounts()*/
}

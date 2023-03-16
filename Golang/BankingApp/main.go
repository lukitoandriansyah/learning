package main

import (
	"BankingApp/api"
	"BankingApp/database/config"
	"BankingApp/database/migrations"
)

func main() {
	config.InitDatabase()
	migrations.Migrate()
	api.StartApi()
}

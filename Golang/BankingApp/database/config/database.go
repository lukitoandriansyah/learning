package config

import (
	"BankingApp/helpers/handler"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/postgres"
)

var DB *gorm.DB

func InitDatabase() {
	db, err := gorm.Open("postgres",
		"host=localhost port=5432 user=postgres dbname=bankapp password=root sslmode=disable")
	handler.HandleErr(err)
	db.DB().SetMaxIdleConns(20)
	db.DB().SetMaxOpenConns(200)
	DB = db
}

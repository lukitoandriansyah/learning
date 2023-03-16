package entities

import "github.com/jinzhu/gorm"

type Transaction struct {
	gorm.Model
	From   uint
	To     uint
	Amount int
}

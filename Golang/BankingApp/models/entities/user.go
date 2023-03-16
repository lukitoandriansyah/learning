package entities

import "github.com/jinzhu/gorm"

type User struct {
	gorm.Model
	Username string
	Email    string
	Password string
}

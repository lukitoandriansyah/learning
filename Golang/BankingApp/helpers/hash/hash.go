package hash

import (
	"BankingApp/helpers/handler"
	"crypto/md5"
	"encoding/hex"
	"golang.org/x/crypto/bcrypt"
)

func HashAndSalt(pass []byte) string {
	hashed, err := bcrypt.GenerateFromPassword(pass, bcrypt.MinCost)
	handler.HandleErr(err)
	return string(hashed)
}

func HashOnlyVulnerable(pass []byte) string {
	hash := md5.New()
	hash.Write(pass)
	return hex.EncodeToString(hash.Sum(nil))
}

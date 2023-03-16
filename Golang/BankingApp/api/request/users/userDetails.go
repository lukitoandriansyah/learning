package users

import (
	"BankingApp/api/response"
	"BankingApp/controller/users"
	"github.com/gorilla/mux"
	"net/http"
)

func GetUser(w http.ResponseWriter, f *http.Request) {
	vars := mux.Vars(f)
	userId := vars["id"]
	auth := f.Header.Get("Authorization")

	user := users.GetUser(userId, auth)
	response.ApiResponse(user, w)
}

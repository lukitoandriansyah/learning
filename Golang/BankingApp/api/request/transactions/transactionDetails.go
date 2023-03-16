package transactions

import (
	"BankingApp/api/response"
	"BankingApp/controller/transactions"
	"github.com/gorilla/mux"
	"net/http"
)

func GetMyTransaction(w http.ResponseWriter, f *http.Request) {
	vars := mux.Vars(f)
	userId := vars["userID"]
	auth := f.Header.Get("Authorization")

	transaction := transactions.GetMyTransaction(userId, auth)
	response.ApiResponse(transaction, w)
}

package transactions

import (
	"BankingApp/api/request"
	"BankingApp/api/response"
	"BankingApp/controller/userAccounts"
	"BankingApp/helpers/handler"
	"BankingApp/models/requestModel"
	"encoding/json"
	"net/http"
)

func Transactions(w http.ResponseWriter, r *http.Request) {
	body := request.ReadBody(r)
	auth := r.Header.Get("Authorization")
	var formattedBody requestModel.TransactionBody
	err := json.Unmarshal(body, &formattedBody)
	handler.HandleErr(err)
	transaction := userAccounts.Transaction(formattedBody.UserId, formattedBody.From, formattedBody.To, formattedBody.Amount, auth)
	response.ApiResponse(transaction, w)
}

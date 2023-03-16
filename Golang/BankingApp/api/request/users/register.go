package users

import (
	"BankingApp/api/request"
	"BankingApp/api/response"
	"BankingApp/controller/users"
	"BankingApp/helpers/handler"
	"BankingApp/models/requestModel"
	"encoding/json"
	"net/http"
)

func Register(w http.ResponseWriter, f *http.Request) {
	body := request.ReadBody(f)
	//Handle login
	var formattedBody requestModel.Register
	err := json.Unmarshal(body, &formattedBody)
	handler.HandleErr(err)
	register := users.Register(formattedBody.Username, formattedBody.Email, formattedBody.Password)

	//Prepare response
	response.ApiResponse(register, w)
}

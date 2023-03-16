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

func Login(w http.ResponseWriter, f *http.Request) {
	//Ready Body
	body := request.ReadBody(f)
	//Handle login
	var formattedBody requestModel.Login
	err := json.Unmarshal(body, &formattedBody)
	handler.HandleErr(err)
	login := users.Login(formattedBody.Username, formattedBody.Password)

	//Prepare response
	response.ApiResponse(login, w)
}

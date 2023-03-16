package request

import (
	"BankingApp/helpers/handler"
	"io/ioutil"
	"net/http"
)

func ReadBody(r *http.Request) []byte {
	body, err := ioutil.ReadAll(r.Body)
	handler.HandleErr(err)
	return body
}

package handler

import (
	"BankingApp/models/response"
	"encoding/json"
	"log"
	"net/http"
)

func HandleErr(err error) {
	if err != nil {
		panic(err.Error())
	}
}

func PanicHandler(next http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		defer func() {
			error := recover()
			if error != nil {
				log.Println(error)
				resp := response.ErrResponse{Message: "Internal Server Error"}
				json.NewEncoder(w).Encode(resp)
			}

		}()
		next.ServeHTTP(w, r)
	})
}

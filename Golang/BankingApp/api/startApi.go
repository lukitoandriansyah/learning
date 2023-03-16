package api

import (
	"BankingApp/api/request/transactions"
	"BankingApp/api/request/users"
	"BankingApp/helpers/handler"
	"fmt"
	"github.com/gorilla/mux"
	"log"
	"net/http"
)

func StartApi() {
	router := mux.NewRouter()
	router.Use(handler.PanicHandler)
	router.HandleFunc("/login", users.Login).Methods("POST")
	router.HandleFunc("/register", users.Register).Methods("POST")
	router.HandleFunc("/transaction", transactions.Transactions).Methods("POST")
	router.HandleFunc("/user/{id}", users.GetUser).Methods("GET")
	router.HandleFunc("/transaction/{userID}", transactions.GetMyTransaction).Methods("GET")
	fmt.Println("App is working on port :9000")
	log.Fatal(http.ListenAndServe(":9000", router))
}

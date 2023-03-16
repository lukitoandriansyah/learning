package response

import (
	"encoding/json"
	"net/http"
)

func ApiResponse(call map[string]interface{}, w http.ResponseWriter) {
	if call["message"] == "all is fine" {
		resp := call
		json.NewEncoder(w).Encode(resp)
	} else {
		//Handle Error
		resp := call
		json.NewEncoder(w).Encode(resp)
	}
}

package response

type ResponseUser struct {
	ID       uint
	Username string
	Email    string
	Accounts []ResponseAccount
}

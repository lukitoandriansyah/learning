const http = require("http")

const requestListener = (request, response) => {
    response.setHeader("Content-Type", "text/html")
    response.statusCode = 200;
    response.end("<h1>This is an HTTP SERVER!</h1>")
}

const server = http.createServer(requestListener)
const  port =5000;
const host="localhost"

server.listen(port, host, ()=>{
    console.log(`Server was running in http://${host}:${port}`)
})
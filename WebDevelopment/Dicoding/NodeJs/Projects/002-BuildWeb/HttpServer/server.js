const http = require("http")

const requestListener = (request, response) => {
    const method = request.method;
    response.setHeader("Content-Type", "text/html")
    response.statusCode = 200;

    if (method === "GET") {
        response.end(`<h1>This is an HTTP SERVER Response ${method}!</h1>`)
    }

    if (method === "POST") {
        response.end(`<h1>This is an HTTP SERVER Response ${method}!</h1>`)
    }

    if (method === "PUT") {
        response.end(`<h1>This is an HTTP SERVER Response ${method}!</h1>`)
    }

    if (method === "DELETE") {
        response.end(`<h1>This is an HTTP SERVER Response ${method}!</h1>`)
    }
}

const server = http.createServer(requestListener)
const port = 5000;
const host = "localhost"

server.listen(port, host, () => {
    console.log(`Server was running in http://${host}:${port}`)
})
const http = require("http")

const requestListener = (request, response) => {
    const method = request.method;
    response.setHeader("Content-Type", "text/html")
    response.statusCode = 200;
    //Move it into logical
//    response.end("<h1>This is an HTTP SERVER!</h1>")

    if(method==="GET"){
        response.end("<h1>This is an HTTP SERVER Response GET!</h1>")
    }

    if(method==="POST"){
        response.end("<h1>This is an HTTP SERVER Response POST!</h1>")
    }

    if(method==="PUT"){
        response.end("<h1>This is an HTTP SERVER Response PUT!</h1>")
    }

    if(method==="DELETE"){
        response.end("<h1>This is an HTTP SERVER Response DELETE!</h1>")
    }
}

const server = http.createServer(requestListener)
const  port =5000;
const host="localhost"

server.listen(port, host, ()=>{
    console.log(`Server was running in http://${host}:${port}`)
})
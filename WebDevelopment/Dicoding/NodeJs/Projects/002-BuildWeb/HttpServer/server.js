const http = require("http")

const requestListener = (request, response) => {
    const method = request.method;
    const url = request.url;
    const respNotFound = "PAGE NOT FOUND"
    const respCanNotAccess = "PAGE CAN NOT ACCESSED"
    //alternatively
    //const {method, url} = request
    response.setHeader("Content-Type", "text/html")

    if(url==="/"){
        if (method==="GET"){
            response.statusCode=200
            response.end(`<h1>This is Home Page</h1>`)
        }else {
            response.statusCode=400
            response.end(`<h1>${respCanNotAccess} with method ${method}</h1>`)
        }

    }else if (url==="/about"){
        if (method==="GET"){
            response.statusCode=200
            response.end(`<h1>This is About Page</h1>`)
        }else if (method==="POST"){
            //add stream logic to add body
            let body = [];
            request.on("data", (chunk)=>{
                body.push(chunk)
            })

            request.on("end", ()=>{
                body = Buffer.concat(body).toString();
                //const {name} = JSON.parse(body)
                const arrBody = JSON.parse(body)
                response.statusCode=200
                response.end(`<h1>Hai, ${arrBody.name}! This is an about page</h1>`)
            })
        }else {
            response.statusCode=400
            response.end(`<h1>${respCanNotAccess} with method ${method}</h1>`)
        }

    }else {
        response.statusCode=404
        response.end(`<h1>${respNotFound}</h1>`)
    }

    /*if (method === "GET") {
        response.end(`<h1>This is an HTTP SERVER Response ${method}!</h1>`)
    }

    if (method === "POST") {
        //add stream logic to add body
        let body = [];
        request.on("data", (chunk)=>{
            body.push(chunk)
        })

        request.on("end", ()=>{
            body = Buffer.concat(body).toString();
            //const {name} = JSON.parse(body)
            const arrBody = JSON.parse(body)
            response.end(`<h1>This is an HTTP SERVER Response ${arrBody.name}!</h1>`)
        })

    }*/

    /*if (method === "PUT") {
        response.end(`<h1>This is an HTTP SERVER Response ${method}!</h1>`)
    }

    if (method === "DELETE") {
        response.end(`<h1>This is an HTTP SERVER Response ${method}!</h1>`)
    }*/




}

const server = http.createServer(requestListener)
const port = 5000;
const host = "localhost"

server.listen(port, host, () => {
    console.log(`Server was running in http://${host}:${port}`)
})
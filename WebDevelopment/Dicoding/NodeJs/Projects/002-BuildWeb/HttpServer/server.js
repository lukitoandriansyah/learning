const http = require("http")

const requestListener = (request, response) => {
    const method = request.method;
    const url = request.url;
    const respNotFound = "PAGE NOT FOUND"
    const respCanNotAccess = "PAGE CAN NOT ACCESSED"
    //alternatively
    //const {method, url} = request
    //response header changed
    //response.setHeader("Content-Type", "text/html")
    response.setHeader("Content-Type", "application/json")
    response.setHeader("X-Powered-By", "NodeJS")

    if(url==="/"){
        if (method==="GET"){
            response.statusCode=200
            //Change response end be jason format
            //response.end(`<h1>This is Home Page</h1>`)
            response.end(JSON.stringify({message:"This is Home Page"}))
        }else {
            response.statusCode=400
            //Change response end be jason format
            //response.end(`<h1>${respCanNotAccess} with method ${method}</h1>`)
            response.end(JSON.stringify({message:`${respCanNotAccess} with method ${method}`}))
        }

    }else if (url==="/about"){
        if (method==="GET"){
            response.statusCode=200
            //Change response end be jason format
            //response.end(`<h1>This is About Page</h1>`)
            response.end(JSON.stringify({message:"This is About Page"}))
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
                //Change response end be jason format
                //response.end(`<h1>Hai, ${arrBody.name}! This is an about page</h1>`)
                response.end(JSON.stringify({message:`Hai, ${arrBody.name}! This is an about page`}))
            })
        }else {
            response.statusCode=400
            //Change response end be jason format
            //response.end(`<h1>${respCanNotAccess} with method ${method}</h1>`)
            response.end(JSON.stringify({message:`${respCanNotAccess} with method ${method}`}))
        }

    }else {
        response.statusCode=404
        //Change response end be jason format
        //response.end(`<h1>${respNotFound}</h1>`)
        response.end(JSON.stringify({message: respNotFound}))
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
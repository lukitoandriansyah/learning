const routes = [
    {
        method: "GET",
        path: "/",
        handler: (request, h) => {
            return "Homepage"
        }
    },
    {
        method: "*",
        path: "/",
        handler: (request, h) => {
            return "Page Can Not Access With These Method"
        }
    },
    {
        method: "GET",
        path: "/about",
        handler: (request, h) => {
            return "About Page"
        }
    },
    {
        method: "*",
        path: "/about",
        handler: (request, h) => {
            return `Page Can Not access with these method`
        }
    },
    {
        method: "GET",
        path: "/hello/{user?}",
        handler: (request, h) => {
            const {user="stranger"} = request.params
            const {lang}=request.query

            if (lang==="id"){
                return `Hai, ${user}`
            }

            return `Hello, ${user}`
        }
    },
    {
        method: "*",
        path: "/{any*}",
        handler: (request, h) => {
            return `Page Not Found`
        }
    },
]

module.exports = routes
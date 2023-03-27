const {addNotesHandler, getAllNotes} = require("./handler");
const routes = [
    {
        method:'POST',
        path:'/notes',
        handler:addNotesHandler,

    },
    {
        method: "GET",
        path: "/notes",
        handler:getAllNotes
    }
];

module.exports=routes;
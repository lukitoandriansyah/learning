const {addNotesHandler, getAllNotes, getNoteById} = require("./handler");
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
    },
    {
        method: "GET",
        path:"/notes/{id}",
        handler:getNoteById
    }
];

module.exports=routes;
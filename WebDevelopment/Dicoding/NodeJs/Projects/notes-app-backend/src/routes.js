const {addNotesHandler, getAllNotes, getNoteById, editData} = require("./handler");
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
    },
    {
        method: "PUT",
        path:"/notes/{id}",
        handler:editData
    }
];

module.exports=routes;
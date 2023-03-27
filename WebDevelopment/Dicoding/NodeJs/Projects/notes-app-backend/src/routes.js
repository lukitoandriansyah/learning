const {addNotesHandler, getAllNotes, getNoteById, editData, deleteNote} = require("./handler");
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
    },
    {
        method: "DELETE",
        path:"/notes/{id}",
        handler:deleteNote
    }
];

module.exports=routes;
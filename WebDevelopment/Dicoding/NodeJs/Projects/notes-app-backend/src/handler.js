const {nanoid} = require('nanoid');
const notes = require('./notes');

const addNotesHandler = (request, h)=>{
    const {title, tags, body} = request.payload;

    const id = nanoid(16);
    const createdAt = new Date().toISOString();
    const updatedAt = createdAt;
    const newNote ={
        title, tags, body, id, createdAt, updatedAt,
    };

    notes.push(newNote);

    const isSuccess = notes.filter((note)=>note.id === id).length>0;

    if (isSuccess){
        const response = h.response({
            status: 'success',
            message: 'Note inserted successfully',
            data:{
                noteId: id,
            },
        });
        response.code(201);

        return response;
    }

    const response = h.response({
        status:'fail',
        message: 'Note failed to inserted',
    });
    response.code(500);
    return response;
};

const getAllNotes = () => ({
  status: "success",
    data:{
      notes,
    }
})

module.exports = {addNotesHandler, getAllNotes};
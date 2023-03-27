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

const getNoteById = (request, h) =>{
    const {id} = request.params;
    const note = notes.filter((n)=> n.id ===id)[0]

    if (note !==undefined){
        return{
            status: "success",
            data: {
                note
            }
        }
    }

    const resp = h.response({
        status:"failed",
        message: "Note Not Found",
    })
    resp.code(404);
    return resp
}

const editData = (request, h) => {
  const {id}=request.params
    const {title, tags, body} = request.payload
    const updatedAt = new Date().toISOString()
    const index = notes.findIndex((note)=>note.id ===id)

    if(index !== -1){
        notes[index] = {
            ...notes[index],
            title,
            tags,
            body,
            updatedAt
        }

        const resp = h.response({
            status:"Success",
            message:"Data was updated successfully"

        })
        resp.code(200)
        return resp
    }

    const resp = h.response({
        status:"Failed",
        message:"Failed to updated Data, Id was not found"
    })
    resp.code(404);
    return resp
}

module.exports = {addNotesHandler, getAllNotes, getNoteById, editData};
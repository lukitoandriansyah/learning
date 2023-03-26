const fs = require("fs")
const readableStream = fs.createReadStream("input.txt",{
    highWaterMark:15
})
const writeableStream = fs.createWriteStream("output.txt")

readableStream.on("readable", ()=>{
    try {
        writeableStream.write(`${readableStream.read()}\n`)
    }catch (error){
        console.log(error)
    }
})



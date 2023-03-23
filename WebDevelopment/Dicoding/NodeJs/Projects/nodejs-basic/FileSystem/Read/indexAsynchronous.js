const fs = require("fs")
const callback = (err, data) => {
    if (err) {
        console.log("Failed to read file")
        return
    }

    console.log(data)

}

fs.readFile("notes.txt", "UTF-8", callback)
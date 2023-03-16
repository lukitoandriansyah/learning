var button = document.getElementById("addButton");
var input = document.getElementById("inputActivity");
var list = document.getElementById("toDoList");

button.addEventListener("click", buttonAddClicked)

function buttonAddClicked(){
    let typeInput=input.value
    if(typeInput!==null){
        let counter=0
        for (let i =0; i<typeInput.length; i++){
            if (typeInput[i]===" "){
                counter++
            }
        }
        if(counter === typeInput.length){
            alert("You have to fill input")
        }else{
            inputListed(typeInput)
        }

    }else {
        alert("You have to fill input")
    }

}

function inputListed(typeInput){
    let createList = document.createElement("li")
    let createValueList = document.createTextNode(typeInput)
    const span = document.createElement("SPAN");
    const txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    createList.appendChild(createValueList)
    list.appendChild(createList).appendChild(span)
}

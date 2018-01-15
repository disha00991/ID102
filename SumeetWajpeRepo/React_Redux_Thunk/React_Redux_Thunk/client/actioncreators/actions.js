
export function increement(index){
    return {
        type:'INCREMENT_LIKES',
        index
    }
}

export function addComment(){
    return {
        type:'ADD_COMMENT'      
        }
}

export function removeComment(index){
    return {
        type:'REMOVE_COMMENT',
        index
    }
}
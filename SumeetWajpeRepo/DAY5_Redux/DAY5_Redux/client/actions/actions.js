export function increement(index){
    return {
        type:'INCREEMENT_LIKES',
        index
    }
}

export function addcomment(){
    return {
        type:'ADD_COMMENT'
    }
}
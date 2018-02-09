export default function saveTrade(state=[],action){
    switch(action.type){
        case 'TRADE_SAVE':
        return state.push({
        	saved: action.saved
        })
        default:
        return state;
    }
}
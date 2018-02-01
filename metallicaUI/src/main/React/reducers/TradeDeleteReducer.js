export default function deleteTrade(state=[],action){
    switch(action.type){
        case 'TRADE_DELETE':
        	return state.push({
            	saved: action.saved
            })
        default:
        return state;
    }
}
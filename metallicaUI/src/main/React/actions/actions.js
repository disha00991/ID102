import axios from 'axios';
		
export function fetchTradeData(){
    var request=axios.get('/trade');
    return (dispatch)=>{
        request.then((response)=>{
            dispatch({type:'FETCH_TRADE',response:response.data})
        })
    }
}

export function fetchCommodityData(){
    var request=axios.get('/commodity');
    return (dispatch)=>{
        request.then((response)=>{
            dispatch({type:'FETCH_COMMODITY',response:response.data})
        })
    }
}

export function fetchLocationData(){
    var request=axios.get('/location');
    return (dispatch)=>{
        request.then((response)=>{
            dispatch({type:'FETCH_LOCATION',response:response.data})
        })
    }
}

export function fetchCounterPartyData(){
    var request=axios.get('/counterparty');
    return (dispatch)=>{
        request.then((response)=>{
            dispatch({type:'FETCH_COUNTERPARTY',response:response.data})
        })
    }
}

export function saveTradeData(trade){
	console.log("save");
    var request=axios.post('/trade/save',trade);
    return (dispatch)=>{
    	console.log("savehello");
        request.then((response)=>{
        	console.log("savehellohello");
            dispatch({type:'TRADE_SAVE',response:response.data})
        })
    }
}

export function editTradeData(trade){
    var request=axios.put('/trade/edit',trade);
    return (dispatch)=>{
        request.then((response)=>{
            dispatch({type:'TRADE_EDIT',response:response.data})
        })
    }
}

export function deleteTradeData(data){
	 var request = axios.delete('trade?tradeId='+data);
	 console.log(request+" "+data);
    return (dispatch)=>{
        request.then((response)=>{
            dispatch({type:'TRADE_DELETE',response:response.data})
        })
    }
}

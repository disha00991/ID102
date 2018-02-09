import axios from 'axios';
		
export function fetchTradeData(){
    var request=axios.get('/trade');
    return (dispatch)=>{
        request.then((response)=>{
        	console.log('fetchTradeData : '+ response.data);
            dispatch({type:'FETCH_TRADE',response:response.data})
        })
    }
}

export function fetchSearchedTradeData(searchTrade){
	console.log("searching action : " + searchTrade.startDate);
	console.log("searching action : " + searchTrade.endDate);
	console.log("searching action : " + searchTrade.commodity);
	console.log("searching action : " + searchTrade.location);
	console.log("searching action : " + searchTrade.counterparty);
	console.log("searching action : " + searchTrade.buyside);
	console.log("searchng action :  " + searchTrade.sellside);
    var request=axios.get('/trade/search?startDate='+searchTrade.startDate+'&endDate='+searchTrade.endDate + 
    		'&commodity='+searchTrade.commodity+'&buyside='+searchTrade.buyside+'&sellside='+searchTrade.sellside+
    		'&counterparty='+searchTrade.counterparty+'&location='+searchTrade.location);
    return (dispatch)=>{
        request.then((response)=>{
        	console.log(response.data);
            dispatch({type:'FETCH_SEARCH_TRADE',response:response.data})
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
    var request=axios.post('/trade',trade);
    return (dispatch)=>{
        request.then((response)=>{
            dispatch({type:'TRADE_SAVE',response:response.data})
        })
        
        fetchTradeData();
    }
}

export function editTradeData(trade){
    var request=axios.put('/trade',trade);
    return (dispatch)=>{
        request.then((response)=>{
            dispatch({type:'TRADE_EDIT',response:response.data})
        })
        
        fetchTradeData();
    }
}

export function deleteTradeData(data){
	 var request = axios.delete('/trade/'+data);
	 console.log(request+" "+data);
    return (dispatch)=>{
        request.then((response)=>{
            dispatch({type:'TRADE_DELETE',response:response.data})
        })
        
        fetchTradeData();
    }
}

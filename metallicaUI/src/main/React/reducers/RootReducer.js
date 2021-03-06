import trades from './TradeReducer';
import save from './TradeSaveReducer';
import edit from './TradeEditReducer';
import deleteTrade from './TradeDeleteReducer'
import commodities from './CommodityReducer';
import locations from './LocationReducer';
import counterparties from './CounterpartyReducer';


import {combineReducers} from 'redux';

var rootReducer=combineReducers({
	trades,
	save,
	edit,
	deleteTrade,
	commodities,
	locations,
	counterparties

})

export default rootReducer;
import Main from './MainComponent';
import * as allActions from '../actions/actions';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';

function mapStateToProps(store){
    return{
        myTrades: store.trades,
        myCommodities : store.commodities,
        myLocations : store.locations,
        myCounterparties : store.counterparties
    }
}

function mapDispatchToProps(dispatch){
    return bindActionCreators(allActions,dispatch)
}
var App=connect(mapStateToProps,mapDispatchToProps)(Main);
export default App;
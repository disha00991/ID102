import Main from './Main.component';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import * as allAction from '../actions/actions';

function mapStateToProps(store1){ 
    console.log("i ran mstp Store: "+store1);
    return {
        myTodos:store1.reduceTodo
    }
}

function mapDispatchToProps(dispatch) {
    console.log("i ran mdtp");
    return bindActionCreators(allAction,dispatch);  
}

var App = connect(mapStateToProps, mapDispatchToProps)(Main);

export default App;
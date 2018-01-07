
import {connect} from 'react-redux';
import { bindActionCreators } from 'redux';
import * as allActions from '../actions/actions';
import Main from './Main.component';

function mapStateToProps(storeData){
        return{
            myposts:storeData.posts,
            mycomments:storeData.comments
        }
}

function mapDispatchToProps(dispatch){
        return bindActionCreators(allActions,dispatch);
}


var App = connect(mapStateToProps,mapDispatchToProps)(Main);
export default App;
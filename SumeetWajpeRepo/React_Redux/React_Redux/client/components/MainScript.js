import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import Main from './Main.component';

import * as actionCreators from '../actioncreators/actions';

function mapStateToProps(stateMeansStore) {
    return {
        myposts:stateMeansStore.posts,
        mycomments:stateMeansStore.comments,
        fetchposts:stateMeansStore.fetchposts
    }
}
function mapDispatchToProps(dispatch) {
    return bindActionCreators(actionCreators,dispatch)

  
}
var App = connect(mapStateToProps,mapDispatchToProps)(Main);

export default App;




import Main from './Main.component';
import {connect} from 'react-redux';

function mapStateToProps(store){
    return {
        myTodos:store.todos
    }
}

var App = connect(mapStateToProps)(Main);

export default App;

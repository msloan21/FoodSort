import AppDispatcher from'../dispatcher/AppDispatcher';

let SortActions = {
    executeAction: function(action) {
        var opts = {headers: {'content-type' : 'application/json'},
            method: 'GET'
        };

        fetch('http://localhost:8080/api/foods/'+action, opts).then(function(response){
            return response.json()
        }).then(function(result){
            SortActions.executeActionComplete(result);
        })
    },
    executeActionComplete: function(data) {
        AppDispatcher.dispatch({
            data: data
        });
    }

}

export default SortActions;
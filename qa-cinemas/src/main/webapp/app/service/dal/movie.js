(function(){
    angular.module("movieApp").service("movieDal", ["dal", movieDal]);
    function movieDal(dal){
        this.getMovies = function(){
            return dal.http.GET("rest/movie/json");
        };
        this.saveMovie = function(movieToSave){
            return dal.http.POST("rest/movie/json");
        };
        this.updateMovie = function(movieToFind, movieToUpdate){};
        this.deleteMovie = function(movieToFind){};
    }
}());
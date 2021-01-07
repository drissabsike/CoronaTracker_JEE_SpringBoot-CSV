$.ajax({
	url: 'Pie_chart',
	success: function(result){
		var Place = JSON.parse(result).Place;
		var PTotal_Cases = JSON.parse(result).PTotal_Cases;
		drawLineChart(Place, PTotal_Cases);
	}
});

$.ajax({
	url: 'Pie_chart',
	success: function(result){
		var Place = JSON.parse(result).Place;
		var PTotal_Death = JSON.parse(result).PTotal_Death;
		drawLineChart2(Place, PTotal_Death);
	}
});

$.ajax({
	url: 'Pie_chart4',
	success: function(result){
		var lieu = JSON.parse(result).lieu;
		var cas = JSON.parse(result).cas;
		drawLineChart4(lieu, cas);
	}
});

$.ajax({
	url: 'Pie_chart4',
	success: function(result){
		var lieu = JSON.parse(result).lieu;
		var deces = JSON.parse(result).deces;
		drawLineChart5(lieu, deces);
	}
});

$.ajax({
	url: 'Pie_chart2',
	success: function(result){
	console.log(result);
	var series = [];
	var data = [];
	for(var i=0; i< result.length; i++){
		var object = {};
		object.name = result[i].ville;
		object.y = 	result[i].cas_covid;
		data.push(object);	
	}
	var seriesObject = {
		name: 'Employees',
		colorByPoint: true,
		data: data
	}	
	series.push(seriesObject);
		drawPieChart3(series);
	}
});


function drawLineChart(Place, PTotal_Cases){
	Highcharts.chart('container', {
	    chart: {
	        type: 'line',
	        width: 700
	    },
	    
	    title: {
	        text: 'Total des cas'
	    },
	
	    xAxis: {
	        categories: Place
	    },
	    
	    tooltip: {
	        formatter: function() {
	          return '<strong>'+this.x+': </strong>'+ this.y+'%';
	        }
	    },
	
	    series: [{
	        data: PTotal_Cases
	    }]
	});
}

function drawLineChart2(Place, PTotal_Death){
	Highcharts.chart('container1', {
	    chart: {
	        type: 'line',
	        width: 700
	    },
	    
	    title: {
	        text: 'Nombre total de deces'
	    },
	
	    xAxis: {
	        categories: Place
	    },
	    
	    tooltip: {
	        formatter: function() {
	          return '<strong>'+this.x+': </strong>'+ this.y+'%';
	        }
	    },
	
	    series: [{
	        data: PTotal_Death
	    }]
	});
}
 function drawPieChart3(series){
 		Highcharts.chart('container2', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: 'Cas de coronavirus au maroc par region 2020'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    accessibility: {
        point: {
            valueSuffix: '%'
        }
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %'
            }
        }
    },
    series: series
});
 } 
 
 function drawLineChart4(lieu, cas){
	Highcharts.chart('container4', {
	    chart: {
	        type: 'line',
	        width: 700
	    },
	    
	    title: {
	        text: 'Nombre total de Cas'
	    },
	
	    xAxis: {
	        categories: lieu
	    },
	    
	    tooltip: {
	        formatter: function() {
	          return '<strong>'+this.x+': </strong>'+ this.y+' Person';
	        }
	    },
	
	    series: [{
	        data: cas
	    }]
	});
}

 function drawLineChart5(lieu, deces){
	Highcharts.chart('container5', {
	    chart: {
	        type: 'line',
	        width: 700
	    },
	    
	    title: {
	        text: 'Nombre total deces'
	    },
	
	    xAxis: {
	        categories: lieu
	    },
	    
	    tooltip: {
	        formatter: function() {
	          return '<strong>'+this.x+': </strong>'+ this.y+' Person';
	        }
	    },
	
	    series: [{
	        data: deces
	    }]
	});
}




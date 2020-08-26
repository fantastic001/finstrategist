<script>
import StockFormService from "./service";

export default {
    name: "StockForm",
    data: function () {
        return {
            data: {
	    },

        };
    },
    methods: {
    	submit: function() 
	{
		StockFormService.submit(this.data).then(response => {
			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;

		});
	}
    }
}
</script>

<template>
    <div class="form-StockForm"> 
        <div class="success-box" v-if="success">Stock saved</div>
	<div v-if="!success"> 
		
		
		<p>
		<input type="text" class="form-control" placeholder="Stock ticker" v-model="data.ticker" />
		</p>
		
		<p>
		<input type="date" class="form-control" placeholder="Date of data" v-model="data.date" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="Closing price in $" v-model="data.close" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="Opening price in $" v-model="data.open" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="The highest daily price in $" v-model="data.high" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="The lowest daily price in $" v-model="data.low" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="Stock dividend" v-model="data.dividend" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="Volume of daily transactions" v-model="data.volume" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>
    </div>

</template>

<style scoped> 

.form-StockForm {

}

.success-box 
{
	backgrund-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>
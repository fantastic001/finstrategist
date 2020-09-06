<script>
import CompanyInfoService from "./service";

export default {
    name: "CompanyInfo",
    data: function () {
        return {
            data: {
	    },

        };
    },
    methods: {
    	submit: function() 
	{
		CompanyInfoService.submit(this.data).then(response => {
			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;

		});
	}
    }
}
</script>

<template>
    <div class="form-CompanyInfo"> 
        <div class="success-box" v-if="success"></div>
	<div v-if="!success"> 
		
		
		<p>
		<input type="text" class="form-control" placeholder="ticker" v-model="data.ticker" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="totalRevenue" v-model="data.totalRevenue" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="netIncome" v-model="data.netIncome" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="assets" v-model="data.assets" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="cash" v-model="data.cash" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="netReceivables" v-model="data.netReceivables" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="inventory" v-model="data.inventory" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="otherCurrentAssets" v-model="data.otherCurrentAssets" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="liabilities" v-model="data.liabilities" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="currentLiabilities" v-model="data.currentLiabilities" />
		</p>
		
		<p>
		<input type="date" class="form-control" placeholder="date" v-model="data.date" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>
    </div>

</template>

<style scoped> 

.form-CompanyInfo {

}

.success-box 
{
	backgrund-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>
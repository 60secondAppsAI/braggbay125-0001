<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <banner-table
            v-if="banners && banners.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:banners="banners"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-banners="getAllBanners"
             >

            </banner-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import BannerTable from "@/components/BannerTable";
import BannerService from "../services/BannerService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    BannerTable,
  },
  data() {
    return {
      banners: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllBanners(sortBy='bannerId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await BannerService.getAllBanners(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.banners.length) {
					this.banners = response.data.banners;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching banners:", error);
        }
        
      } catch (error) {
        console.error("Error fetching banner details:", error);
      }
    },
  },
  mounted() {
    this.getAllBanners();
  },
  created() {
    this.$root.$on('searchQueryForBannersChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllBanners();
    })
  }
};
</script>
<style></style>

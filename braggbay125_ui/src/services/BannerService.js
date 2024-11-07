import http from "../http-common"; 

class BannerService {
  getAllBanners(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/banner/banners`, searchDTO);
  }

  get(bannerId) {
    return this.getRequest(`/banner/${bannerId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/banner?field=${matchData}`, null);
  }

  addBanner(data) {
    return http.post("/banner/addBanner", data);
  }

  update(data) {
  	return http.post("/banner/updateBanner", data);
  }
  
  uploadImage(data,bannerId) {
  	return http.postForm("/banner/uploadImage/"+bannerId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new BannerService();


package appeng.client.render.model.pipeline.cable;


import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.property.IExtendedBlockState;

import appeng.api.client.BakingPipeline;
import appeng.api.client.BakingPipelineElement;
import appeng.api.parts.IPart;
import appeng.api.util.AEPartLocation;
import appeng.block.networking.BlockCableBus;
import appeng.client.render.model.pipeline.TintIndexModifier;
import appeng.parts.CableBusContainer;


public class Parts implements BakingPipelineElement<BakedQuad, BakedQuad>
{

	private final BakingPipeline rotatingPipeline;
	private final TintIndexModifier tintIndexModifier;
	private final BakingPipeline tintIndexFixPipeline;

	public Parts( BakingPipeline rotatingPipeline, TintIndexModifier tintIndexModifier, BakingPipeline tintIndexFixPipeline )
	{
		this.rotatingPipeline = rotatingPipeline;
		this.tintIndexModifier = tintIndexModifier;
		this.tintIndexFixPipeline = tintIndexFixPipeline;
	}

	@Override
	public List<BakedQuad> pipe( List<BakedQuad> elements, IBakedModel parent, IBlockState state, EnumFacing side, long rand )
	{
		if( state != null )
		{
			CableBusContainer cableBus = ( (IExtendedBlockState) state ).getValue( BlockCableBus.cableBus );
			for( AEPartLocation facing : AEPartLocation.SIDE_LOCATIONS )
			{
				IPart part = cableBus.getPart( facing );
				if( part != null )
				{
					tintIndexModifier.setTintTransformer( tint -> ( facing.ordinal() << 2 ) | tint );
					elements.addAll( tintIndexFixPipeline.pipe( part.getOrBakeQuads( rotatingPipeline, state, side, rand ), parent, state, side, rand ) );
				}
			}
		}
		return elements;
	}

}
